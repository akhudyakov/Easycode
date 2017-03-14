package hometaskThreads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 22.02.2017.
 */
public class SharedList {

    private List<String> stringArrayList = new ArrayList<>();

    public  void addToList(String s) {
        stringArrayList.add(s);
    }

    public List<String> getStringArrayList() {
        return stringArrayList;
    }

    @Override
    public String toString() {
        String temp = "{";
        for (int i = 0; i < stringArrayList.size(); i++) {
            if (i+1!=stringArrayList.size()) {
                temp += "\"" + stringArrayList.get(i) + "\",";
            } else {
                temp += "\"" + stringArrayList.get(i) + "\"";
            }
       }
        return  temp + "}" ;
    }
}




