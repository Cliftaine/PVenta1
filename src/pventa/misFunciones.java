/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pventa;

/**
 *
 * @author jahziel
 */
public class misFunciones {
    Integer counter=0;
    String value=""; 
    public boolean strInt(String strTxtInt){
        int cont;
        String str;
        boolean var;
        
        var = true;
        str = strTxtInt;
        
        if(str.isEmpty()){
            var = false;
        }else{
            for(cont = 0; cont < str.length() && var == true;cont++){
                if(str.charAt(cont) == '0'){
                    var = true;
                }else if(str.charAt(cont) == '1'){
                    var = true;
                }else if(str.charAt(cont) == '2'){
                    var = true;
                }else if(str.charAt(cont) == '3'){
                    var = true;
                }else if(str.charAt(cont) == '4'){
                    var = true;
                }else if(str.charAt(cont) == '5'){
                    var = true;
                }else if(str.charAt(cont) == '6'){
                    var = true;
                }else if(str.charAt(cont) == '7'){
                    var = true;
                }else if(str.charAt(cont) == '8'){
                    var = true;
                }else if(str.charAt(cont) == '9'){
                    var = true;
                }else {
                    var = false;
                }
            }
        }

        return var;
    }
    
    public boolean strDec(String strTxtDec){
    int cont;
        String str;
        boolean var;
        
        var = true;
        str = strTxtDec;
        if(strTxtDec.isEmpty()){
            var = false;
        }else{
            for(cont = 0; cont < str.length() && var == true;cont++){
                if(str.charAt(cont) == '0'){
                    var = true;
                }else if(str.charAt(cont) == '1'){
                    var = true;
                }else if(str.charAt(cont) == '2'){
                    var = true;
                }else if(str.charAt(cont) == '3'){
                    var = true;
                }else if(str.charAt(cont) == '4'){
                    var = true;
                }else if(str.charAt(cont) == '5'){
                    var = true;
                }else if(str.charAt(cont) == '6'){
                    var = true;
                }else if(str.charAt(cont) == '7'){
                    var = true;
                }else if(str.charAt(cont) == '8'){
                    var = true;
                }else if(str.charAt(cont) == '9'){
                    var = true;
                }else if(str.charAt(cont) == '.'){
                    var = strInt(strTxtDec.substring(cont+1));
                }    
            }
        }
        
    
    return var;
    }
    
    public boolean convertir(String txtDec){
        boolean var = false;
        String txt;
        txt = txtDec;
        try {
            if(Float.valueOf(txt) >= 0){
                var = true;
            }else{
                var = false;
            }
        } catch (Exception e) {
            var = false;
        }
        return var;
    }
    
     public boolean convertir2(String txtInt){
        boolean var = false;
        String txt;
        txt = txtInt;
        try {
            if(Integer.valueOf(txt) >= 0){
                var = true;
            }else{
                var = false;
            }
        } catch (Exception e) {
            var = false;
        }
        return var;
    }
     
    public String getStringOfNumber(Integer $num){
        this.counter = $num;
        return doThings($num);
    }
    
    private String doThings(Integer _counter){
        //Limite
        if(_counter >2000000)
            return "DOS MILLONES";
        
        switch(_counter){
            case 0: return "CERO";
            case 1: return "UN"; //UNO
            case 2: return "DOS";
            case 3: return "TRES";
            case 4: return "CUATRO";
            case 5: return "CINCO"; 
            case 6: return "SEIS";
            case 7: return "SIETE";
            case 8: return "OCHO";
            case 9: return "NUEVE";
            case 10: return "DIEZ";
            case 11: return "ONCE"; 
            case 12: return "DOCE"; 
            case 13: return "TRECE";
            case 14: return "CATORCE";
            case 15: return "QUINCE";
            case 20: return "VEINTE";
            case 30: return "TREINTA";
            case 40: return "CUARENTA";
            case 50: return "CINCUENTA";
            case 60: return "SESENTA";
            case 70: return "SETENTA";
            case 80: return "OCHENTA";
            case 90: return "NOVENTA";
            case 100: return "CIEN";
            
            case 200: return "DOSCIENTOS";
            case 300: return "TRESCIENTOS";
            case 400: return "CUATROCIENTOS";
            case 500: return "QUINIENTOS";
            case 600: return "SEISCIENTOS";
            case 700: return "SETECIENTOS";
            case 800: return "OCHOCIENTOS";
            case 900: return "NOVECIENTOS";
            
            case 1000: return "MIL";
            
            case 1000000: return "UN MILLON";
            case 2000000: return "DOS MILLONES";
        }
        if(_counter<20){
            //System.out.println(">15");
            return "DIECI"+ doThings(_counter-10);
        }
        if(_counter<30){
            //System.out.println(">20");
            return "VEINTI" + doThings(_counter-20);
        }
        if(_counter<100){
            //System.out.println("<100"); 
            return doThings( (int)(_counter/10)*10 ) + " Y " + doThings(_counter%10);
        }        
        if(_counter<200){
            //System.out.println("<200"); 
            return "CIENTO " + doThings( _counter - 100 );
        }         
        if(_counter<1000){
            //System.out.println("<1000");
            return doThings( (int)(_counter/100)*100 ) + " " + doThings(_counter%100);
        } 
        if(_counter<2000){
            //System.out.println("<2000");
            return "MIL " + doThings( _counter % 1000 );
        } 
        if(_counter<1000000){
            String var;
            //System.out.println("<1000000");
            var = doThings((int)(_counter/1000)) + " MIL" ;
            if(_counter % 1000!=0){
                //System.out.println(var);
                var += " " + doThings(_counter % 1000);
            }
            return var;
        }
        if(_counter<2000000){
            return "UN MILLON " + doThings( _counter % 1000000 );
        } 
        return "";
    }    
}
