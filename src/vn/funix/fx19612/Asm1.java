package vn.funix.fx19612;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Asm1 {
    public static String inputNewNum;
    public static final Scanner sc = new Scanner(System.in);
    public static final String AUTHOR = "NGAN HANG SO";
    public static final String VERSION = "FX19612@v1.0.0";

    public static void main(String[] args) {
        System.out.println("+----------+--------------------+---------+");
        System.out.println("| " + AUTHOR + " | " + VERSION + "           |");
        System.out.println("+----------+--------------------+---------+");
        System.out.println("| 1. Nhap CCCD                            |");
        System.out.println("| 2. Thoat                                |");
        System.out.println("+----------+--------------------+---------+");
        System.out.println("Nhap CCCD de tim hieu trong thong tin chi tiet ");
        System.out.println("Chuc Nang: ");
        checkNum();
    }

    public static void checkNum() {
        try {
            String Num = sc.nextLine();
            int Numb = Integer.parseInt(Num);
            if (Numb == 2) {
                System.out.println("Cam on da su dung dich vu.");
            } else if (Numb == 1) {
                EsAndHard();
            } else {
                System.out.println("Neu muon tiep tuc su dung dich vu, hay nhap lai.");
                checkNum();
            }
        } catch (Exception e) {
            System.out.println("Xin vui long nhap lai yeu cau cua ban.");
            checkNum();
        }
    }

    public static void EsAndHard() {
        System.out.println("vui long chon che do");
        System.out.println("| 1. EASY");
        System.out.println("| 2. HARD");
        String mode = sc.nextLine();
        try {
            int checkMode = Integer.parseInt(mode);
            if (checkMode == 1) {
                EasyCheck();
            } else if (checkMode == 2) {
                HardCheck();
            }
        } catch (Exception e) {
            System.out.println("Hay chon lai che do");
            EsAndHard();
        }
    }

    public static void EasyCheck() {
        int rdCode = (int) (Math.random() * 899) + 100;
        String newRandomNumber = String.valueOf(rdCode);
        System.out.println("Nhap ma xac thuc :" + rdCode);
        String inputNum = sc.nextLine();
        try {
            if (inputNum.equals(newRandomNumber)) {
                MyNumber();
            } else {
                System.out.println("Vui long nhap lai ma xac thuc");
                EasyCheck();
            }
        } catch (Exception e) {
            System.out.println("Vui long nhap lai ma xac thuc");
            EasyCheck();
        }
    }

    public static void HardCheck() {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String alphaUpperCase = alpha.toUpperCase();
        String rdNumber = "0123456789";
        String CheckCodeHard = alpha + alphaUpperCase + rdNumber;
        StringBuilder StrBuilder = new StringBuilder();
        Random rd = new Random();

        for (int i = 0; i < 6; i++) {
            int index = rd.nextInt(CheckCodeHard.length());
            char rdChar = CheckCodeHard.charAt(index);
            StrBuilder.append(rdChar);

        }
        String randomString = StrBuilder.toString();
        System.out.println("Nhap ma xac thuc :" + randomString);
        String passNumberIn = sc.nextLine();

        if (passNumberIn.equals(randomString)) {
            MyNumber();
        } else {
            System.out.println("Sai ma! Vui long nhap lai!");
            HardCheck();
        }
    }

    public static void MyNumber() {
        System.out.println("Vui long nhap so CCCD:");
        String myNumber = sc.nextLine();
        inputNewNum = myNumber;
        String provinceNum = inputNewNum.substring(0, 3);
        String genderNum = inputNewNum.substring(3, 4);
        String yearNum = inputNewNum.substring(4, 6);
        int checkProvinceNum = Integer.parseInt(provinceNum);
        int checkGenderNum = Integer.parseInt(genderNum);
        int checkYearNum = Integer.parseInt(yearNum);

        if (myNumber.length() == 12 && myNumber.matches("\\d+")) {
            if (checkProvinceNum > 96 || checkGenderNum > 9 || checkYearNum > 99) {
                System.out.println("Ma sai!");
                MyNumber();
            } else checkInformation();
        } else {
            System.out.println("So CCCD khong hop le");
            MyNumber();
        }
    }

    public static void checkInformation() {
        System.out.println("| 1. Kiem tra noi sinh");
        System.out.println("| 2. Kiem tra gioi tinh, nam sinh");
        System.out.println("| 3. Kiem tra so ngau nhien");
        System.out.println("| 0. Thoat");
        System.out.println("Chon chuc nang ban muon su dung:");
        String checkMyInfo = sc.next();

        try {
            Integer.parseInt(checkMyInfo);
            switch (checkMyInfo) {
                case "1":
                    placeBirth();
                    break;
                case "2":
                    ageAndSex();
                    break;
                case "3":
                    myRandomNumber();
                    break;
                case "0":
                    System.out.println("Cam on da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Xin hay nhap lai");
                    checkInformation();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Xin hay nhap lai");
            checkInformation();
        }
    }

    public static void placeBirth() {
        HashMap<String, String> provinceMap = new HashMap<>();
        provinceMap.put("001", "Ha Noi");
        provinceMap.put("002", "Ha Giang");
        provinceMap.put("004", "Cao Bang");
        provinceMap.put("006", "Bac Kan");
        provinceMap.put("008", "Tuyen Quang");
        provinceMap.put("010", "Lao Cai");
        provinceMap.put("011", "Dien Bien");
        provinceMap.put("012", "Lai Chau");
        provinceMap.put("014", "Son La");
        provinceMap.put("015", "Yen Bai");
        provinceMap.put("017", "Hoa Binh");
        provinceMap.put("019", "Thai Nguyen");
        provinceMap.put("020", "Lang Son");
        provinceMap.put("022", "Quang Ninh");
        provinceMap.put("024", "Bac Giang");
        provinceMap.put("025", "Phu Tho");
        provinceMap.put("026", "Vinh Phuc");
        provinceMap.put("027", "Bac Ninh");
        provinceMap.put("030", "Hai Duong");
        provinceMap.put("031", "Hai Phong");
        provinceMap.put("033", "Hung Yen");
        provinceMap.put("034", "Thai Binh");
        provinceMap.put("035", "Ha Nam");
        provinceMap.put("036", "Nam Dinh");
        provinceMap.put("037", "Ninh Binh");
        provinceMap.put("038", "Thanh Hoa");
        provinceMap.put("040", "Nghe An");
        provinceMap.put("042", "Ha Tinh");
        provinceMap.put("044", "Quang Binh");
        provinceMap.put("045", "Quang Tri");
        provinceMap.put("046", "Thua Thien Hue");
        provinceMap.put("048", "Da Nang");
        provinceMap.put("049", "Quang Nam");
        provinceMap.put("051", "Quang Ngai");
        provinceMap.put("052", "Binh Dinh");
        provinceMap.put("054", "Phu Yen");
        provinceMap.put("056", "Khanh Hoa");
        provinceMap.put("058", "Ninh Thuan");
        provinceMap.put("060", "Binh Thuan");
        provinceMap.put("062", "Kon Tum");
        provinceMap.put("064", "Gia Lai");
        provinceMap.put("066", "Dak Lak");
        provinceMap.put("067", "Dak Nong");
        provinceMap.put("068", "Lam Dong");
        provinceMap.put("070", "Binh Phuoc");
        provinceMap.put("072", "Tay Ninh");
        provinceMap.put("074", "Binh Duong");
        provinceMap.put("075", "Dong Nai");
        provinceMap.put("077", "Ba Ria - Vung Tau");
        provinceMap.put("079", "Ho Chi Minh");
        provinceMap.put("080", "Long An");
        provinceMap.put("082", "Tien Giang");
        provinceMap.put("083", "Ben Tre");
        provinceMap.put("084", "Tra Vinh");
        provinceMap.put("086", "Vinh Long");
        provinceMap.put("087", "Dong Thap");
        provinceMap.put("089", "An Giang");
        provinceMap.put("091", "Kien Giang");
        provinceMap.put("092", "Can Tho");
        provinceMap.put("093", "Hau Giang");
        provinceMap.put("094", "Soc Trang");
        provinceMap.put("095", "Bac Lieu");
        provinceMap.put("096", "Ca Mau");
        String provinceNum = inputNewNum.substring(0, 3);
        String provinceName = provinceMap.get(provinceNum);

        System.out.println(provinceName == null ? "Unknow" : "\n" + provinceName + "\n");
        checkYeuCau();

    }

    public static void ageAndSex() {
        String yearNum = inputNewNum.substring(4, 6);
        int newYearNum = Integer.parseInt(yearNum);

        String genderNum = inputNewNum.substring(3, 4);
        int newGenderNum = Integer.parseInt(genderNum);

        switch (newGenderNum) {
            case 0:
                System.out.println("\nGioi tinh: Nam | " + (newYearNum + 1900)+"\n");
                break;
            case 1:
                System.out.println("\nGioi tinh: Nu | " + (newYearNum + 1900)+"\n");
                break;
            case 2:
                System.out.println("\nGioi tinh: Nam | " + (newYearNum + 2000)+"\n");
                break;
            case 3:
                System.out.println("\nGioi tinh: Nu | " + (newYearNum + 2100)+"\n");
                break;
            case 4:
                System.out.println("\nGioi tinh: Nam | " + (newYearNum + 2200)+"\n");
                break;
            case 5:
                System.out.println("\nGioi tinh: Nu | " + (newYearNum + 2300)+"\n");
                break;
            case 6:
                System.out.println("\nGioi tinh: Nam | " + (newYearNum + 2400)+"\n");
                break;
            case 7:
                System.out.println("\nGioi tinh: Nu | " + (newYearNum + 2500)+"\n");
                break;
            case 8:
                System.out.println("\nGioi tinh: Nam | " + (newYearNum + 2600)+"\n");
                break;
            case 9:
                System.out.println("\nGioi tinh: Nu | " + (newYearNum + 2700)+"\n");
                break;
        }
        checkYeuCau();
    }

    public static void myRandomNumber() {
        String randomNumber = inputNewNum.substring(6, 12);
        System.out.println("\nSo ngau nhien: "+randomNumber+"\n");
        checkYeuCau();
    }

    public static void checkYeuCau() {
        System.out.println("| 1. Tiep tuc su dung chuong trinh");
        System.out.println("| 2. Quay lai ban dau");
        String tp = sc.next();
        try {
            int tpInt = Integer.parseInt(tp);
            if (tpInt == 1) {
                checkInformation();
            } else if (tpInt == 2) {
                System.out.println("| 1. Nhap CCCD");
                System.out.println("| 2. Thoat");
                checkNum();
            }
        } catch (Exception e) {
            System.out.println("Vui long nhap lai yeu cau!");
            checkYeuCau();
        }

    }
}
