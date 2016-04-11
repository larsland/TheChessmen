package tdt4240.chess.Views;


public interface Renderer {

    public void render(float delta);
    public void setSize(int width, int height);
    public void dispose();
}
