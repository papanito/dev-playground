# Example and test for the problem mentioned in https://stackoverflow.com/questions/68649472/struggling-to-match-exact-regex-to-my-strings/68649709#68649709
using System;
using System.Text.RegularExpressions;

public class RegexTest{
    public static void Main(){
        string pattern = @"\wDRC\/TF8(?=\.|$)";  
        Regex re = new Regex(pattern);  
        string[] text = { 
            "CD.TR.DRC/TF8",
            "CD.TR.DRC/TF8/A8",
            "CD.TR.DRC/TF8.PB",
            "DRC/TF8",
            "DDRC/TF8"
        };
        foreach(string str in text){
            if (re.IsMatch(str)){
                Console.WriteLine(str);
            }
        }
    }
}