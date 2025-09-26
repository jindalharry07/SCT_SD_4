import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductScraper {
    public static void main(String[] args) {
        String url = "http://books.toscrape.com/";
        String fileName = "products.csv";

        try {
            // Create HTTP client & fetch HTML
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String html = response.body();

            // CSV writer
            try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
                // Write CSV header
                pw.println("Title,Price,Availability");

                // Find all product blocks
                Pattern productPattern = Pattern.compile("<article class=\"product_pod\">(.*?)</article>", Pattern.DOTALL);
                Matcher productMatcher = productPattern.matcher(html);

                while (productMatcher.find()) {
                    String productBlock = productMatcher.group(1);

                    // Extract title
                    String title = extract(productBlock, "title=\"(.*?)\"");
                    // Extract price
                    String price = extract(productBlock, "<p class=\"price_color\">(.*?)</p>");
                    // Extract availability (removes tags + trims spaces)
                    String availability = extract(productBlock, "<p class=\"instock availability\">(.*?)</p>", true);
                    availability = availability.replaceAll("<.*?>", "").trim();

                    // Escape CSV values
                    title = escapeCsv(title);
                    availability = escapeCsv(availability);

                    // Write row
                    pw.println("\"" + title + "\"," + price + ",\"" + availability + "\"");
                }
            }

            System.out.println("Data saved to " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Extract function (overloaded)
    private static String extract(String text, String regex) {
        return extract(text, regex, false);
    }

    private static String extract(String text, String regex, boolean dotall) {
        Pattern pattern = dotall
                ? Pattern.compile(regex, Pattern.DOTALL)
                : Pattern.compile(regex);
        Matcher m = pattern.matcher(text);
        return m.find() ? m.group(1) : "";
    }

    // CSV Escaping (handles commas and quotes safely)
    private static String escapeCsv(String value) {
        if (value.contains("\"")) {
            value = value.replace("\"", "\"\"");
        }
        return value;
    }
}
