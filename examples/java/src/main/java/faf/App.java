package faf;

import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import com.restfb.json.JsonObject;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App
{
    private static final String MY_ACCESS_TOKEN = "CAACEdEose0cBAL0RekruLhvtbSsDSj6nazcqso2SmOXxpMd5PeFWCVZB8Ym0hltiu7s9kSyWDI3PZCk9KGVZAju860GGbZAy5z2KZCpTdZC6hJf506RZBtmImkoKCmCfdSyL6aXgShfvZBgI2uR1EOQIZAAdmbaKLVyTbGSCDgmS6GwDBvnlo5Qj5nPLVl0MVFEMZD";

    private static int countOccurences(String the, String[] in) {
      int counter = 0;
      for(String str : in) {
        if(the.equals(str)) {
          counter++;
        }
      }
      return counter;
    }
    public static void main( String[] args )
    {
        FacebookClient client = new DefaultFacebookClient(MY_ACCESS_TOKEN);
        String query = "SELECT movies FROM user WHERE uid in (SELECT uid2 from friend where uid1 = me())";
        List<JsonObject> result = client.executeFqlQuery(query, JsonObject.class);

        String bigstring = "";
        for (JsonObject obj : result) {
            bigstring += ( obj.getString("movies") + ", " );
        }
        String[] titles = bigstring.split(", ");
        Map map = new HashMap();

        for (String title : titles) {
            map.put(title, countOccurences(title, titles));
        }

        Iterator iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry mEntry = (Map.Entry) iter.next();
            System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
        }
    }
}
