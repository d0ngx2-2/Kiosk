package lv2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        // 접속 문구 및 종료 선택 화면
        System.out.println("만다린에 오신 것을 환영합니다. 메뉴를 선택하시겠습니까?[나가기]");
        String choice = sc.next();

        if("나가기".equals(choice)){
            System.exit(0);
        }else {
            System.out.println("메뉴를 불러오겠습니다.");
        }
        // 메뉴 불러오기
        while(true){
        System.out.println("[ 만다린 메뉴 ]");
        System.out.println(1 + " 유니짜장  " + "|" + "W  " + 6900 + "  | " + "맛있는 유니 짜장");
        System.out.println(2 + " 간짜장    " + "|" + "W  " + 7500 + " | " + "맛있는 간짜장");
        System.out.println(3 + " 짬뽕      " + "|" + "W  " + 8900 + " | " + "맛있는 짬뽕");
        System.out.println(4 + " 삼선짬뽕   " + "|" + "W " + 11900 + " | " + "맛있는 삼선짬뽕");
        System.out.println(5 + " 종료하기");
        System.out.println("원하시는 메뉴를 선택하여주세요.");
        int choiceNum = sc.nextInt();
        if(choiceNum == 1){
            System.out.println("장바구니에 담겼습니다.");
        }else if(choiceNum == 2){
            System.out.println("장바구니에 담겼습니다.");
        }else if(choiceNum == 3){
            System.out.println("장바구니에 담겼습니다.");
        }else if(choiceNum == 4){
            System.out.println("장바구니에 담겼습니다.");
        }else if(choiceNum == 5){
            System.exit(0);
        }else{
            System.out.println("잘못된 입력입니다.");
        }
        }
    }
    }