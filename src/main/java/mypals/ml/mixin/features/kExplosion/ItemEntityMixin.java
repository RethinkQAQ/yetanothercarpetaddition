package mypals.ml.mixin.features.kExplosion;

import mypals.ml.interfaces.ExplosionExtension;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity{
    public ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Unique
    @Override
    public boolean isImmuneToExplosion(Explosion explosion) {
        return ((ExplosionExtension)explosion).preservesDecorativeEntities() ? super.isImmuneToExplosion(explosion) : true;
    }
}
