package M5_MVCPattern;

public class ProgrammableCoin extends CryptoCurrency
{
    //private String script = "";
    private Programmable program;

    public ProgrammableCoin(String name, Programmable program)
    {
        super(name);
        this.program = program;
    }

    public ProgrammableCoin(String name, String symbol, String description, int circulatingSupply, int marketCap)
    {
        super(name, symbol, description, circulatingSupply, marketCap);
    }

//    public void setScript(String scriptArg)
//    {
//        script += scriptArg;
//    }
//
//    public String getScript()
//    {
//        return script;
//    }

    public String runProgram()
    {
        return program.getScript();
    }

    @Override
    public String toString()
    {
        String results = "";
        results += super.toString();
        return results;
    }


    @Override
    public boolean equals(Object object)
    {
        if(object instanceof ProgrammableCoin)
        {
            return super.equals(object);
        }
        return false;
    }
}
