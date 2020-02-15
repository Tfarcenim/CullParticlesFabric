package tfar.cullparticles.mixin;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import tfar.cullparticles.MixinHooks;

@Mixin(ParticleManager.class)
public class MixinParticleManager {
  @Redirect(method = "renderParticles",
          at = @At(value = "INVOKE",
                  target = "net/minecraft/client/particle/Particle.buildGeometry(Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/client/render/Camera;F)V"))
  private void cullParticles(Particle particle, VertexConsumer buffer, Camera renderInfo, float partialTicks){
    MixinHooks.cullParticles(particle,buffer,renderInfo,partialTicks);
  }
}
