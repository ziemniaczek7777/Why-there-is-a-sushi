package net.ziemniak.whythereisasushi.screen;

import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class SushiScreenHandlers {

    // Rejestracja typu ekranu dla SushiTray
    public static final ScreenHandlerType<SushiTrayScreenHandler> SUSHI_TRAY =
            Registry.register(
                    Registries.SCREEN_HANDLER,
                    Identifier.of("whythereisasushi", "sushi_tray"),
                    new ScreenHandlerType<>(
                            SushiTrayScreenHandler::new,
                            FeatureFlags.VANILLA_FEATURES
                    )
            );

    public static void init() {
        // metoda init jest opcjonalna, ale dobrym zwyczajem jest jej wywołanie w ModClientInitializer
    }
}
