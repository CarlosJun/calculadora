public class Calculadora {
    public String sayHello(String nome, String sobrenome) {
        return "Fala "+ nome + " " + sobrenome;
    }
    // Defini��o do m�todo de soma da calculadora
    public double soma(double oper1, double oper2) {
        return oper1 + oper2;
    }
    // Defini��o do m�todo de subtra��o da calculadora
    public double subtracao(double oper1, double oper2) {
        return oper1 - oper2;
    }
    // Defini��o do m�todo de divis�o da calculadora
    public double divisao(double oper1, double oper2) {
        return oper1 / oper2;
    }
    // Defini��o do m�todo de multiplica��o da calculadora
    public double multiplicacao(double oper1, double oper2) {
        return oper1 * oper2;
    }
}