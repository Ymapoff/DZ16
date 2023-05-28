public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("игрок с именем" + playerName + "не найден");
    }

}
