///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.moh.uemoagovies.helpers;
//
//import java.util.function.UnaryOperator;
//import javafx.scene.control.TextFormatter;
//
///**
// *
// * @author soul
// */
//public class ConvertisseurDonnees {
//    
//    public ConvertisseurDonnees(){
//        
//    }
//    private TextFormatter integerOnlyFormatter(){
//        
//        
//        final UnaryOperator<TextFormatter.Change> filter = (TextFormatter.Change change) -> {
//
//            String text = change.getText();
//            if(change.isReplaced()){
//                if(text.matches("[^0-9]"))
//                    change.setText(change.getControlText().substring(
//                            change.getRangeStart(),change.getRangeEnd()));
//            }
//            if(change.isAdded()){
//                if(change.getControlText().contains(".")){
//                    if(text.matches("[^0-9]")){
//                        change.setText("");
//                    }
//                        } else if(text.matches("[^0-9.]")) {
//                            change.setText("");
//                        }
//            }
//                   //text.matches(String.valueOf(decimalPoint)) || 
//               return  change;
//      
//        };  
//        
//        return new TextFormatter(filter);
//    }
//}
