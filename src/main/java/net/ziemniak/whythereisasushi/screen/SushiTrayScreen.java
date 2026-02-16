package net.ziemniak.whythereisasushi.screen;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.gl.RenderPipelines;

public class SushiTrayScreen extends HandledScreen<SushiTrayScreenHandler> {

    private static final Identifier TEXTURE =
            Identifier.of("whythereisasushi", "textures/gui/sushi_tray.png");

    public SushiTrayScreen(SushiTrayScreenHandler handler,
                           PlayerInventory inventory,
                           Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;  // standardowe wymiary GUI
        this.backgroundHeight = 166;
    }

    @Override
    protected void drawBackground(DrawContext context,
                                  float delta,
                                  int mouseX,
                                  int mouseY) {

        // Renderujemy teksturę GUI z odpowiednim RenderPipeline
        context.drawTexture(
                RenderPipelines.GUI_TEXTURED, // pipeline
                TEXTURE,                       // lokalizacja tekstury
                x, y,                          // pozycja GUI
                0, 0,                          // początek fragmentu tekstury
                backgroundWidth, backgroundHeight, // szerokość i wysokość fragmentu
                backgroundWidth, backgroundHeight  // rozmiar całej tekstury
        );
    }
}
