public class Inscription {
    public int number;
    public Category category;
    public Participant participant;
    public int abono;

    public Inscription(int number, Category category, Participant participant) {
        this.number = number;
        this.category = category;
        this.participant = participant;
        int abonoTemporal = 0;
        //Calculamos el abono segun la categoria y edad
        switch (category.id) {
            case 1:
                if (participant.age < 18){
                    abonoTemporal = 1300;
                }else {
                    abonoTemporal = 1500;
                }
                break;
            case 2:
                if (participant.age < 18){
                    abonoTemporal = 2000;
                }else {
                    abonoTemporal = 2300;
                }
                break;
            case 3:
                if (participant.age < 18){
                    //Error no se permite
                    abonoTemporal = 0;
                }else {
                    abonoTemporal = 28000;
                }
                break;
        }
        
        //Asignamos el abono al inscripcion actual
        this.abono = abonoTemporal;
        
        //Añadimos la inscripcion a la lista de inscritos de la categoria
        if(this.abono > 0) {
            category.subscriptions.add(this);
        }
    }
}
