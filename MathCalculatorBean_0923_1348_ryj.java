// 代码生成时间: 2025-09-23 13:48:43
package com.example.mathcalculator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Managed Bean to handle mathematical operations.
 */
@ManagedBean
@RequestScoped
public class MathCalculatorBean {

    // Attributes to hold operation operands and result
    private Double operand1;
    private Double operand2;
    private Double result;
    private String operation;
    private String errorMessage;

    // Getters and setters for the attributes
    public Double getOperand1() {
        return operand1;
    }

    public void setOperand1(Double operand1) {
        this.operand1 = operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public void setOperand2(Double operand2) {
        this.operand2 = operand2;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Method to perform mathematical operations based on the selected operation.
     *
     * @return String indicating the navigation outcome.
     */
    public String calculate() {
        try {
            switch (operation) {
                case "add":
                    result = operand1 + operand2;
                    break;
                case "subtract":
                    result = operand1 - operand2;
                    break;
                case "multiply":
                    result = operand1 * operand2;
                    break;
                case "divide":
                    if (operand2 == 0) {
                        throw new IllegalArgumentException("Cannot divide by zero.");
                    }
                    result = operand1 / operand2;
                    break;
                default:
                    errorMessage = "Invalid operation selected.";
                    break;
            }
        } catch (Exception e) {
            errorMessage = "Error occurred: " + e.getMessage();
        }

        return "success";
    }
}
