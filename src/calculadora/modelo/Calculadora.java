/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.modelo;

import java.util.*;

/**
 *
 * @author anamm
 */
public class Calculadora {

    private List memoria = new ArrayList();

    public float calcular() throws Exception {
        try {
            float op1, op2, resultado = 0;
            String operador = "";

            while (memoria.size() > 1) {

                op1 = Float.parseFloat(memoria.get(0).toString());
                memoria.remove(0);

                if (memoria.size() > 0) {
                    operador = memoria.get(0).toString();
                    memoria.remove(0);
                }

                if (memoria.size() > 0) {
                    op2 = Float.parseFloat(memoria.get(0).toString());
                    memoria.remove(0);
                } else {
                    op2 = 0;
                }
                switch (operador.charAt(0)) {
                    case '+':
                        resultado = somar(op1, op2);
                        break;
                    case '-':
                        resultado = subtrair(op1, op2);
                        break;
                    case '*':
                        resultado = multiplicar(op1, op2);
                        break;
                    case '/':
                        resultado = dividir(op1, op2);
                        break;
                }

                if (memoria.size() > 0) {
                    memoria.add(0, String.valueOf(resultado));
                }

            }

            if (memoria.size() == 1) {
                resultado = Float.parseFloat(memoria.get(0).toString());
                limparMemoria();
            }
            return resultado;
        } catch (Exception e) {
            throw new Exception(e);

        }

    }

    private float somar(float op1, float op2) {
        return op1 + op2;
    }

    private float subtrair(float op1, float op2) {
        return op1 - op2;
    }

    private float multiplicar(float op1, float op2) {
        return op1 * op2;
    }

    private float dividir(float op1, float op2) throws ArithmeticException {
        if (op2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        return op1 / op2;
    }

    public void limparMemoria() {
        memoria.clear();
    }

    public void adicionarValorMemoria(float operando) {
        memoria.add(operando);
    }

    public void adicionarValorMemoria(char operador) throws ArithmeticException {
        if ((operador != '+') && (operador != '-') && (operador != '*') && (operador != '/')) {
            throw new ArithmeticException("Operador não disponível para uso nesta calculadora");
        }

        memoria.add(operador);
    }

    public String getMemoria() {
        String texto = " ";
        for(Object simbolo : memoria){
            texto += simbolo.toString();
        }
        return texto;
    }
}
