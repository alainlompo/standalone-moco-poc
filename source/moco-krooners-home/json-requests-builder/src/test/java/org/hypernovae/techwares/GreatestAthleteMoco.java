package org.hypernovae.techwares;

public class GreatestAthleteMoco extends SimpleJsonClient { 

    public GreatestAthleteMoco(String jsonDatas) { 
            super(jsonDatas); 
            this.setjSessionId("awK325Su2489Urw44G-5JIMH"); 
            this.setContext("/moco_demo/showtime"); 
            this.setPort(10500);
            this.executeJson(); 
    } 
    
    public static void main(String[] args) { 
            StringBuilder requestBuilder = new StringBuilder(); 
            requestBuilder.append("{") 
            .append("\"sport\":\"boxing\",") 
            .append("\"cuptype\":\"world-wide\",") 
            .append("\"comparison\":\"best\",") 
            .append("\"number\":\"all\"") 
            
            .append("}"); 
            
            new GreatestAthleteMoco(requestBuilder.toString()); 
    } 

}

