package org.wso2;

import java.nio.file.Paths;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.wso2.antlr.CompilerLexer;
import org.wso2.antlr.CompilerParser;
<<<<<<< HEAD
=======
import org.wso2.tree.CompilationUnit;
import org.wso2.tree.KeyValuePair;
import org.wso2.tree.NatP;
import org.wso2.tree.NatS;

import java.nio.file.Paths;
import java.util.List;
>>>>>>> updated grammar

public class Main {
    public static void main(String[] args) {
        try {
            /*
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            CharStream charStream = CharStreams.fromString(input);
            */


            CharStream charStream = CharStreams.fromPath(
                    Paths.get(Main.class.getClassLoader().getResource("input.txt").getFile()));
            CompilerLexer lexer = new CompilerLexer(charStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CompilerParser parser = new CompilerParser(tokenStream);

            ParseTreeWalker walker = new ParseTreeWalker();
            parser.addParseListener(new Listener());
            CompilerParser.CompilationUnitContext compilationUnitContext = parser.compilationUnit();
<<<<<<< HEAD
=======

            // Access the Context
            KeyValuePair NatSKeyValuePair1 = new KeyValuePair("url", "localhost:4222");
            KeyValuePair NatSKeyValuePair2 = new KeyValuePair("topic", "sample topic");
            NatS natS = new NatS();
            natS.addKeyValuePair(NatSKeyValuePair1);
            natS.addKeyValuePair(NatSKeyValuePair2);

/*          KeyValuePair NatPKeyValuePair1 = new KeyValuePair("url", "localhost:4222");
            KeyValuePair NatPKeyValuePair2 = new KeyValuePair("topic", "sample topic");
            KeyValuePair NatPKeyValuePair3 = new KeyValuePair("message", "sample message");
            NatP natP = new NatP();
            natP.addKeyValuePair(NatPKeyValuePair1);
            natP.addKeyValuePair(NatPKeyValuePair2);
            natP.addKeyValuePair(NatPKeyValuePair3);*/

            CompilationUnit compilationUnit = new CompilationUnit(natS);

            List<KeyValuePair> keyValuePairsNatS = compilationUnit.getNatS().getKeyValuePairs();
            for (KeyValuePair valuePair : keyValuePairsNatS) {
                System.out.println(valuePair.getKey() + ": " + valuePair.getValue());
            }

/*            List<KeyValuePair> keyValuePairsNatP = compilationUnit.getNatP().getKeyValuePairs();
            for (KeyValuePair valuePair : keyValuePairsNatP) {
                System.out.println(valuePair.getKey() + ": " + valuePair.getValue());
            }*/

>>>>>>> updated grammar
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}