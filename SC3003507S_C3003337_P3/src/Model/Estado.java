package Model;
public class Estado {
    public enum EstadoClinico {
        ALTA("ALTA"),
        ENFERMARIA("ENFERMARIA"), UTI("UTI");
        private String descricao;

        EstadoClinico(String descricao) {
            this.descricao = descricao;
        }


        public String getDescricao() {
            return descricao;
        }


    }
}


