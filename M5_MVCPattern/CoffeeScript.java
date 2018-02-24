package M5_MVCPattern;

public class CoffeeScript implements Programmable
{
    @Override
    public String getScript()
    {
        return "if(tired)\n{\n\tgetJava();\n}\n";
    }
}
