//нарисовать поле для игры в крестики нолики

public class Field {
    private  String[] values=new String[9];

    public void createField(){
        for (int i = 0; i < values.length; i++) {
            values[i]="\u00b7";
        }
    }
    public void showField(){
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]+"\t");
            if((i+1)%3==0){
                System.out.println();
            }
        }
        System.out.println(values);
    }

    public void setValue(int index, String value){
        this.values[index]=value;
    }

    public String getValue(int index){
        return this.values[index];
    }

}