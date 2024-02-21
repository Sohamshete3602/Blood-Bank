import static java.lang.Math.sqrt;
class ProbStat_7
{
     public static void main(String[] args) 
     {
        Capacitor C1=new Capacitor(751,140,3.00);  
        C1.cal_capacitance();
        C1.cal_charge(); 
     }
    final double Pi=3.141;
    int frequency;
    int peack_output_voltage;
    double rms_current;  
    AC_Generator()
    {
        frequency=0;
        peack_output_voltage=0;
        rms_current=0;
    }

}

class Capacitor extends AC_Generator
{
    int frequency;         
    int peack_output_voltage;
    double rms_current;

    double rms_voltage;
    double capacitance;
    double Max_charge;

    Capacitor (int frequency, int peack_output_voltage, double rms_current)
    {
        super.frequency=frequency;
        super.peack_output_voltage=peack_output_voltage;
        super.rms_current=rms_current;
        this.rms_voltage=super.peack_output_voltage/sqrt(2);
    }
    void cal_capacitance()
    { 
        capacitance=(super.rms_current/(2*Pi*super.frequency*this.rms_voltage));
        System.out.format("The capacitance  of  the  capacitor: %.7f F(farad) ≅ %.6f     F(farad)\n",capacitance,capacitance);
    }
    void cal_charge()
    {
        Max_charge=capacitance*super.peack_output_voltage;
        System.out.format("The maximum charge on the capacitor: %.7f C(coulomb) ≅ %.4f   C(coulomb)",Max_charge,Max_charge);
    }
}
