//ход человека
//поверка победил ли человек
//ход компьютера
//проверка есть ли победитель
//передать ход человеку

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private final Field field=new Field();
    private final Scanner scanner=new Scanner(System.in);
    private final Random random=new Random();
    private boolean isWinner=false;

    public void start() {
        field.createField();
        int count=0;

        do {
            //покажем поле
            field.showField();
            userStep();
            count++;
            isWinnerX();
            if (count ==9) isWinnerDraw();

            generatePCStep();
            isWinner0();
            count++;

        } while (!isWinner);
    }

    private boolean isWinner() {
        return true;
    }

    private void userStep(){
        int value=getUserInput()-1;
        field.setValue(value, "X");
    }

    private  int getUserInput() {
        boolean isTrue = false;
        int input;
        do {
            System.out.println("Введите номер куда хотите потавить крестик от 1 до 9");
            input = scanner.nextInt();
            if (input < 0 || input > 10) {
                System.out.println("Введено некоректное число введите еще раз");
            } else if (!isEmpty(input)) {
                System.out.println("Введите еще раз поле уже занято");
            }else {

                isTrue = true;
                return input;
            }
        }while (!isTrue);

        return input;
    }
    private boolean isEmpty(int i){
        if (field.getValue(i)!="\u00b7"&&field.getValue(i).equals("0")&&field.getValue(i).equals("X"))
        return false;
        else
        return true;

    }

    private  void generatePCStep(){
        boolean isTrue=false;
        do {
            int i= random.nextInt(9);
            if (field.getValue(i)=="\u00b7"){
                this.field.setValue(i,"0");
                isTrue=true;
            }
        }while (!isTrue);


    }


    private boolean isWinnerX(){
        if (isWinDiagonalX()==true||isWinHorizontalX()==true||isWinDiagonalX()==true){
            System.out.println("Вы победили");
            return isWinner=true;
        }else return isWinner=false;

    }

    private boolean isWinner0(){
        if (isWinDiagonal0()==true||isWinHorizontal0()==true||isWinDiagonal0()==true){
            System.out.println("Компютер победили");
            return isWinner=true;
        }else return isWinner=false;

    }
    private boolean isWinnerDraw(){
        if (isWinDiagonal0()==true||isWinHorizontal0()==true||isWinDiagonal0()==true){
            System.out.println("ходы закончились, ничья");
            return isWinner=true;
        }else return isWinner=false;

    }

    private boolean isWinHorizontalX(){
        if (field.getValue(0)=="X"&&field.getValue(1)=="X"&&field.getValue(2)=="X"||
                field.getValue(3)=="X"&&field.getValue(4)=="X"&&field.getValue(5)=="X"||
                field.getValue(6)=="X"&&field.getValue(7)=="X"&&field.getValue(8)=="X")
            return true;
        else  return false;
    }

    private  boolean  isWinVerticalX(){
        if (field.getValue(0)=="X"&&field.getValue(3)=="X"&&field.getValue(7)=="X"||
                field.getValue(1)=="X"&&field.getValue(4)=="X"&&field.getValue(8)=="X"||
                field.getValue(2)=="X"&&field.getValue(5)=="X"&&field.getValue(9)=="X")
            return true;
        else  return false;
    }
    private boolean isWinDiagonalX(){
        if (field.getValue(0)=="X"&&field.getValue(4)=="X"&&field.getValue(8)=="X"||
                field.getValue(2)=="X"&&field.getValue(4)=="X"&&field.getValue(6)=="X")
            return true;
        else  return false;
    }

    private boolean isWinHorizontal0(){
        if (field.getValue(0)=="0"&&field.getValue(1)=="0"&&field.getValue(2)=="0"||
                field.getValue(3)=="0"&&field.getValue(4)=="0"&&field.getValue(5)=="0"||
                field.getValue(6)=="0"&&field.getValue(7)=="0"&&field.getValue(8)=="0")
            return true;
        else  return false;
    }

    private  boolean  isWinVertical0(){
        if (field.getValue(0)=="0"&&field.getValue(3)=="0"&&field.getValue(7)=="0"||
                field.getValue(1)=="0"&&field.getValue(4)=="0"&&field.getValue(8)=="0"||
                field.getValue(2)=="0"&&field.getValue(5)=="0"&&field.getValue(9)=="0")
            return true;
        else  return false;
    }
    private boolean isWinDiagonal0(){
        if (field.getValue(0)=="0"&&field.getValue(4)=="0"&&field.getValue(8)=="0"||
                field.getValue(2)=="0"&&field.getValue(4)=="0"&&field.getValue(6)=="0")
            return true;
        else  return false;
    }

}


