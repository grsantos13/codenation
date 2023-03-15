package challenge;

import java.util.ArrayList;
import java.util.List;


public class Estacionamento {
    private final int VAGAS_ESTACIONAMENTO = 10;
    private final int IDADE_IDOSO = 55;
    private final int IDADE_HABILITACAO = 18;
    private final int MAXIMO_PONTOS_HABILITACAO = 20;
    private List<Carro> listaCarrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
        Motorista motorista = carro.getMotorista();

        if (isValid(motorista)){
            if (carrosEstacionados() == 10){
                removerCarro();
            }
            listaCarrosEstacionados.add(carro);
        }
    }
    private void removerCarro(){
        for (int i = 0; i < VAGAS_ESTACIONAMENTO; i++){
            if (listaCarrosEstacionados.get(i).getMotorista().getIdade() < IDADE_IDOSO) {
                listaCarrosEstacionados.remove(i);
                break;
            }
        }

        if (carrosEstacionados() == 10){
            throw new EstacionamentoException("Todos os motoristas estacionados são idosos.");
        }
    }
    public int carrosEstacionados() {
        return listaCarrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return listaCarrosEstacionados.contains(carro);
    }
    private boolean isValid(Motorista motorista) {
        if (motorista == null || motorista.getIdade() < IDADE_HABILITACAO || motorista.getPontos() > MAXIMO_PONTOS_HABILITACAO) {
            throw new EstacionamentoException("Ocorreu um erro. Verifique os dados do motorista.");
        }else{
            return true;
        }
    }
}
