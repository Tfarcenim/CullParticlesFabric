package tfar.cullparticles.mixin;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import tfar.cullparticles.Capture;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer implements Capture {

	@Unique private Frustum frustum;

	@ModifyVariable(
					method = "render",
					at = @At(value = "INVOKE",
									target = "net/minecraft/client/render/BackgroundRenderer.render(Lnet/minecraft/client/render/Camera;FLnet/minecraft/client/world/ClientWorld;IF)V")
	)

	private Frustum captureFrustrum(Frustum frustum2) {
		return frustum = frustum2;
	}

	@Override
	public Frustum capturedFrustum() {
		return frustum;
	}
}
