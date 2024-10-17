
public record Moneda(String result, String base_code, String target_code, double conversion_rate, double conversion_result) {

    public Moneda(String result, String base_code, String target_code, double conversion_rate, double conversion_result) {
        this.result = result;
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }

    public String toString() {
        return " [" + this.base_code + "] corresponde al valor final =>>> " + this.conversion_result + " [" + this.target_code + "] \n";
    }

    public String result() {
        return this.result;
    }

    public String base_code() {
        return this.base_code;
    }

    public String target_code() {
        return this.target_code;
    }

    public double conversion_rate() {
        return this.conversion_rate;
    }

    public double conversion_result() {
        return this.conversion_result;
    }
}
