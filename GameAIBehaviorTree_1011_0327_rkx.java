// 代码生成时间: 2025-10-11 03:27:31
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// 游戏AI行为树节点基类
abstract class BehaviorTreeNode implements Serializable {
    private String name;
    private boolean enabled;

    public BehaviorTreeNode(String name) {
        this.name = name;
        this.enabled = true;
    }

    public abstract BehaviorTreeStatus tick();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

// 行为树状态
enum BehaviorTreeStatus {
    SUCCESS, FAILURE, RUNNING
}

// 行为树
class BehaviorTree implements Serializable {
    private BehaviorTreeNode root;
    private Map<String, BehaviorTreeNode> nodesMap = new HashMap<>();

    public BehaviorTree(BehaviorTreeNode root) {
        this.root = root;
    }

    public BehaviorTreeStatus tick() {
        if (root != null && root.isEnabled()) {
            return root.tick();
        }
        return BehaviorTreeStatus.FAILURE;
    }

    public void addNode(BehaviorTreeNode node) {
        nodesMap.put(node.getName(), node);
    }

    public BehaviorTreeNode getNode(String nodeName) {
        return nodesMap.get(nodeName);
    }
}

// 行为树节点示例：选择节点
class SelectorNode extends BehaviorTreeNode {
    private BehaviorTreeNode[] children;

    public SelectorNode(String name, BehaviorTreeNode[] children) {
        super(name);
        this.children = children;
    }

    @Override
    public BehaviorTreeStatus tick() {
        for (BehaviorTreeNode child : children) {
            if (child.isEnabled()) {
                BehaviorTreeStatus status = child.tick();
                if (status == BehaviorTreeStatus.SUCCESS) {
                    return BehaviorTreeStatus.SUCCESS;
                }
            }
        }
        return BehaviorTreeStatus.FAILURE;
    }
}

// 行为树节点示例：序列节点
class SequenceNode extends BehaviorTreeNode {
    private BehaviorTreeNode[] children;

    public SequenceNode(String name, BehaviorTreeNode[] children) {
        super(name);
        this.children = children;
    }

    @Override
    public BehaviorTreeStatus tick() {
        for (BehaviorTreeNode child : children) {
            if (!child.isEnabled()) {
                return BehaviorTreeStatus.FAILURE;
            }
            BehaviorTreeStatus status = child.tick();
            if (status != BehaviorTreeStatus.SUCCESS) {
                return status;
            }
        }
        return BehaviorTreeStatus.SUCCESS;
    }
}

// 行为树节点示例：条件节点
class ConditionNode extends BehaviorTreeNode {
    private boolean condition;

    public ConditionNode(String name, boolean condition) {
        super(name);
        this.condition = condition;
    }

    @Override
    public BehaviorTreeStatus tick() {
        return condition ? BehaviorTreeStatus.SUCCESS : BehaviorTreeStatus.FAILURE;
    }
}

// 行为树节点示例：行为节点
class ActionNode extends BehaviorTreeNode {
    private Runnable action;

    public ActionNode(String name, Runnable action) {
        super(name);
        this.action = action;
    }

    @Override
    public BehaviorTreeStatus tick() {
        if (action != null) {
            action.run();
            return BehaviorTreeStatus.SUCCESS;
        }
        return BehaviorTreeStatus.FAILURE;
    }
}

// 游戏AI行为树的JSF管理类
public class GameAIBehaviorTreeBean {
    private BehaviorTree behaviorTree;

    public GameAIBehaviorTreeBean() {
        // 初始化行为树
        behaviorTree = new BehaviorTree(createRootNode());
    }

    private BehaviorTreeNode createRootNode() {
        // 创建行为树根节点
        SelectorNode rootNode = new SelectorNode("Root", new BehaviorTreeNode[]{
                new SequenceNode("Sequence1", new BehaviorTreeNode[]{
                        new ConditionNode("Condition1", true),
                        new ActionNode("Action1", () -> System.out.println("Action1 executed")),
                        new ConditionNode("Condition2", false)
                })
        });
        return rootNode;
    }

    public void tick(ActionEvent event) {
        try {
            BehaviorTreeStatus status = behaviorTree.tick();
            switch (status) {
                case SUCCESS:
                    System.out.println("Behavior tree tick succeeded");
                    break;
                case FAILURE:
                    System.out.println("Behavior tree tick failed");
                    break;
                case RUNNING:
                    System.out.println("Behavior tree is running");
                    break;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ticking behavior tree", e.getMessage()));
        }
    }
}
