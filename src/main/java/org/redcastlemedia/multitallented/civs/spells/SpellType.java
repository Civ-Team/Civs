package org.redcastlemedia.multitallented.civs.spells;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.redcastlemedia.multitallented.civs.items.CVItem;
import org.redcastlemedia.multitallented.civs.items.CivItem;
import org.redcastlemedia.multitallented.civs.spells.effects.*;
import org.redcastlemedia.multitallented.civs.spells.targets.BlockTarget;
import org.redcastlemedia.multitallented.civs.spells.targets.NearbyTarget;
import org.redcastlemedia.multitallented.civs.spells.targets.Target;
import org.redcastlemedia.multitallented.civs.spells.targets.VectorTarget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellType extends CivItem {
    @Getter
    private final Map<String, Integer> allowedActions = new HashMap<>();
    @Getter
    private final FileConfiguration config;
    @Getter
    private int expPerUse = 0;

    public SpellType(List<String> reqs,
                     String name,
                     Material material,
                     CVItem shopIcon,
                     int qty,
                     int min,
                     int max,
                     double price,
                     String permission,
                     List<String> groups,
                     FileConfiguration config,
                     boolean isInShop,
                     int level,
                     int expPerUse) {
        super(reqs,
                false,
                ItemType.SPELL,
                name,
                material,
                shopIcon,
                qty,
                min,
                max,
                price,
                permission,
                groups,
                isInShop,
                level);
        this.config = config;
        this.expPerUse = expPerUse;
    }

    public static Target getTarget(String type,
                                   String key,
                                   ConfigurationSection config,
                                   int level,
                                   Player caster,
                                   Spell spell) {
        if (type.equals("vector")) {
            return new VectorTarget(spell, key, caster, level, config);
        } else if (type.equals("nearby")) {
            return new NearbyTarget(spell, key, caster, level, config);
        } else if (type.equals("block")) {
            return new BlockTarget(spell, key, caster, level, config);
        }
        return null;
    }

    public static Effect getEffect(String type,
                                   String key,
                                   Object config,
                                   int level,
                                   Object target,
                                   Player caster,
                                   Spell spell) {
        if (type.contains("^")) {
            type = type.split("\\^")[0];
        }
        if (type.equals(SpellEffectConstants.DAMAGE)) {
            return new DamageEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.COOLDOWN)) {
            return new CooldownEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.POTION)) {
            return new CivPotionEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.STAMINA)) {
            return new StaminaEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.VELOCITY)) {
            return new VelocityEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.CANCEL)) {
            return new CancelEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.SOUND)) {
            return new SoundEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.PARTICLE)) {
            return new ParticleEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.FALL)) {
            return new FallEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.HEAL)) {
            return new HealEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.IGNITE)) {
            return new IgniteEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.TELEPORT)) {
            return new TeleportEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.MANA)) {
            return new ManaEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.ITEM)) {
            return new ItemEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.EXEMPTION)) {
            return new ExemptionEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.CLEANSE)) {
            return new CleanseEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.CIVSTATE)) {
            return new CivStateEffect(spell, key, target, caster, level, config);
        } else if (type.equals(SpellEffectConstants.EFFECT)) {
            return new EffectEffect(spell, key, target, caster, level, config);
        }

        return null;
    }
}
