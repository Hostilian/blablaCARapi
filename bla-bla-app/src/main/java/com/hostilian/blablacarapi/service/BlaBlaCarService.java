@Service
public class BlaBlaCarService {
    private final WebClient webClient;

    @Value("${blablacar.api.key}")
    private String apiKey;

    @Value("${blablacar.api.base-url}")
    private String baseUrl;

    public BlaBlaCarService() {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Token " + apiKey)
                .build();
    }

    public List<Stop> getAllStops() {
        return webClient.get()
                .uri("/stops")
                .retrieve()
                .bodyToMono(StopsResponse.class)
                .block()
                .getStops();
    }
}
