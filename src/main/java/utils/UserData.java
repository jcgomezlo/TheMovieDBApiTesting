package utils;

import Entities.User;
public class UserData implements DataDeliver<User[]> {

    private ExcelUtils excelUtils;
    private static UserData instance;

    private UserData(String path, String sheet){
            excelUtils = new ExcelUtils(path, sheet);
    }

    public static UserData getInstance(String path, String sheet){
        if(instance == null){
            instance = new UserData(path,sheet);
        }
        return instance;
    }

    public static void main(String[] args){
        UserData userData = new UserData("data/data.xlsx","Sheet1");
        System.out.println(userData.getData()[1].getFirstName());
    }


    @Override
    public  User[] getData() {
        int numRows = excelUtils.getRowCount();
        User[] users = new User[numRows-1];

        for(int i = 1; i < numRows; i++){
            String firstName = (String) excelUtils.getCellData(i,0);
            String lastName = (String) excelUtils.getCellData(i,1);
            int subjectId =  Integer.parseInt((String) excelUtils.getCellData(i,2));
            users[i-1] = new User(firstName,lastName,subjectId);
        }

        return users;

    }
}
