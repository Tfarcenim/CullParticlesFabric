package tfar.cullparticles;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;

public class MixinHooks {
  public static final MinecraftClient mc = MinecraftClient.getInstance();
  public static void cullParticles(Particle particle, VertexConsumer buffer, Camera camera, float partialTicks) {
    if (((Capture)mc.worldRenderer).capturedFrustum().isVisible(particle.getBoundingBox()))
      particle.buildGeometry(buffer,camera,partialTicks);
  }
}
