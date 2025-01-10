public class BaseConverter{
    public double celsius;
    
    BaseConverter(double celsius)
    {
        this.celsius = celsius;
    }

    public double convert(String target){
        switch (target.toLowerCase()) {
            case "kelvin" -> {
                return celsiusToKelvin();
            }
            case "fahrenheit" -> {
                return celsiusToFahrenheit();
            }
            default -> throw new IllegalArgumentException("Eror: " + target);
        }
    }

    private double celsiusToKelvin() {
        return celsius + 273.15;
    }

    private double celsiusToFahrenheit() {
        return (celsius * 1.8) + 32;
    }
}