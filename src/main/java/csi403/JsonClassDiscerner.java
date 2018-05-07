package csi403; 

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.io.Serializable;


public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {

        ObjectMapper mapper = new ObjectMapper();


        //ArrayList tempList = new ArrayList();

        //PriorityQueue<SubInJSON> queue = new PriorityQueue<>(new Sort());

        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        //ArrayList outList = new ArrayList();
        InList inList = null;

        try {
            //while(!queue.isEmpty()){
            //    outList.add(queue.peek().getName());
            //    queue.remove();
            //}
            //OutJSON outJSON = new OutJSON();
            //outJSON.setOutList(outList);

            inList = mapper.readValue(jsonStr, InList.class);

            SortAlg sortAlg = new SortAlg();


            for (int i = 0; i < inList.getInList().size(); i++) {
                sortAlg.add(inList.getInList().get(i).getSmart().get(0).toString(), inList.getInList().get(i).getSmart().get(1).toString());
            }


            //Serialize the output
            OutJSON outJSON = new OutJSON();
            outJSON.setOutList(sortAlg);
            JsonSerializer jsonSerializer = new JsonSerializer();
            return jsonSerializer.serialize(outJSON);
        }

        catch (Exception e) {
            // e.printStackTrace();

            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
        //return outList;
    }



    public class SortAlg extends ArrayList<String> {

        public void add(String smartGuy1, String smartGuy2){
            int a = indexOf(smartGuy1);
            int b = indexOf(smartGuy2);
            if (b == -1){
                add(smartGuy2);
                b = indexOf(smartGuy2);
            }
            if (a == -1){
                add(b,smartGuy1);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        String test = "{ \"inList\" : [ " +
                "{\"smarter\" :[\"Einstein\", \"Feynmann\"]}," +
                "{\"smarter\" :[\"Feynmann\", \"Gell-Mann\"]}, " +
                "{\"smarter\" :[\"Gell-Mann\", \"Thorne\"]}, " +
                "{\"smarter\" :[\"Einstein\", \"Lorentz\"]}, " +
                "{\"smarter\" :[\"Lorentz\", \"Planck\"]}, " +
                "{\"smarter\" :[\"Hilbert\", \"Noether\"]}," +
                "{\"smarter\" :[\"Poincare\", \"Noether\"]} ]}";
        System.out.println("-------------------------------------------------------------");
        System.out.println(new JsonClassDiscerner().discern(test));
        System.out.println("-------------------------------------------------------------");
    }
}
