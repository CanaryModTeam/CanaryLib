package net.canarymod.api.factory;

import com.google.common.base.Predicate;
import net.canarymod.api.ai.AIArrowAttack;
import net.canarymod.api.ai.AIAttackOnCollide;
import net.canarymod.api.ai.AIAvoidEntity;
import net.canarymod.api.ai.AIBeg;
import net.canarymod.api.ai.AIBreakDoor;
import net.canarymod.api.ai.AIControlledByPlayer;
import net.canarymod.api.ai.AICreeperSwell;
import net.canarymod.api.ai.AIDefendVillage;
import net.canarymod.api.ai.AIEatGrass;
import net.canarymod.api.ai.AIFindEntityNearest;
import net.canarymod.api.ai.AIFindEntityNearestPlayer;
import net.canarymod.api.ai.AIFleeSun;
import net.canarymod.api.ai.AIFollowGolem;
import net.canarymod.api.ai.AIFollowOwner;
import net.canarymod.api.ai.AIFollowParent;
import net.canarymod.api.ai.AIHarvestFarmland;
import net.canarymod.api.ai.AIHurtByTarget;
import net.canarymod.api.ai.AILeapAtTarget;
import net.canarymod.api.ai.AILookAtTradePlayer;
import net.canarymod.api.ai.AILookAtVillager;
import net.canarymod.api.ai.AILookIdle;
import net.canarymod.api.ai.AIMate;
import net.canarymod.api.ai.AIMoveIndoors;
import net.canarymod.api.ai.AIMoveThroughVillage;
import net.canarymod.api.ai.AIMoveTowardsRestriction;
import net.canarymod.api.ai.AIMoveTowardsTarget;
import net.canarymod.api.ai.AINearestAttackableTarget;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.living.EntityLiving;
import net.canarymod.api.entity.living.IronGolem;
import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.api.entity.living.animal.EntityAnimal;
import net.canarymod.api.entity.living.animal.Tameable;
import net.canarymod.api.entity.living.animal.Wolf;
import net.canarymod.api.entity.living.humanoid.Villager;
import net.canarymod.api.entity.living.monster.Creeper;
import net.canarymod.api.entity.living.monster.EntityMob;
import net.canarymod.api.entity.living.monster.RangedAttackMob;

/**
 * AI Factory
 *
 * @author Aaron
 */
public interface AIFactory {

    /**
     * Returns a new {@link AIArrowAttack} Instance
     *
     * @param mob
     *         mob being assigned to this ai
     * @param moveSpeed
     *         move speed towards the target
     * @param attackTimeModifier
     *         higher numbers means longer attack times
     * @param maxRangedAttackTime
     *         longest wait between attacks
     * @param maxAttackDistance
     *         farthest distance the mob will attack from
     *
     * @return a new {@link AIArrowAttack} Instance
     */
    AIArrowAttack newAIArrowAttack(RangedAttackMob mob, double moveSpeed, int attackTimeModifier, int maxRangedAttackTime, int maxAttackDistance);

    /**
     * Returns a new {@link AIAttackOnCollide} Instance
     *
     * @param creature
     *         creature this AI belongs to.
     * @param targetClass
     *         The class type of the target of this AI.
     * @param moveSpeed
     *         speed the entity will move at when engaged in this activity.
     * @param persistant
     *         Whether or not the mob will attempt to find the target again after
     *         it is out of sight or unable to reach the target because it cannot
     *         find any path to take.
     *
     * @return A new {@link AIAttackOnCollide} Instance
     */
    AIAttackOnCollide newAIAttackOnCollide(EntityMob creature, Class<? extends LivingBase> targetClass, double moveSpeed, boolean persistant);

    /**
     * Returns A new {@link AIAvoidEntity} Instance
     *
     * @param mob
     *         The mob this ai belongs to
     * @param predicate
     *         A very specific {@link Predicate} implementation. <br><br>
     *         The Predicate implementation of {@link Predicate#apply(java.lang.Object)}
     *         will be passed type of {@link net.canarymod.api.entity.Entity}.  Your method
     *         will need to assert true if the AI should avoid the given entity type. Or
     *         false if it does not need to avoid the entityType.
     * @param radius
     *         Radius of area to check around mob
     * @param farSpeed
     *         movement speed when far from avoided entity.
     * @param nearSpeed
     *         movement speed when near avoided entity
     *
     * @return A new {@link AIAvoidEntity} Instance
     */
    AIAvoidEntity newAIAvoidEntity(EntityMob mob, Predicate predicate, float radius, double farSpeed, double nearSpeed);

    /**
     * Returns A new {@link AIBeg} Instance
     *
     * @param wolf
     *         Wolf that owns this AI.
     * @param minBegDistance
     *         distance threshold for a wolf to start begging.
     *         If a player is farther away, it won't beg.
     *
     * @return A new {@link AIBeg} Instance
     */
    AIBeg newAIBeg(Wolf wolf, float minBegDistance);

    /**
     * Returns A new {@link AIBreakDoor} Instance.
     * This AI class will allow the owner to break down doors in its way.
     *
     * @param entity
     *         The entity that owns this AI
     *
     * @return A new {@link AIBreakDoor} Instance
     */
    AIBreakDoor newAIBreakDoor(EntityLiving entity);

    /**
     * Returns A new {@link AIControlledByPlayer} Instance.
     *
     * @param entity
     *         The entity that owns this AI.
     * @param speed
     *         The speed at which the entity will move.
     *
     * @return A new {@link AIControlledByPlayer} Instance.
     */
    AIControlledByPlayer newAIControlledByPlayer(EntityLiving entity, float speed);

    /**
     * Returns A new {@link AICreeperSwell} Instance.
     *
     * @param creeper
     *         The {@link Creeper} that owns this AI.
     *
     * @return A new {@link AICreeperSwell} Instance.
     */
    AICreeperSwell newAICreeperSwell(Creeper creeper);

    /**
     * Returns A new {@link AIDefendVillage} Instance.
     *
     * @param ironGolem
     *         The {@link IronGolem} this AI belongs to.
     *
     * @return A new {@link AIDefendVillage} Instance.
     */
    AIDefendVillage newAIDefendVillage(IronGolem ironGolem);

    /**
     * Returns A new {@link AIEatGrass} Instance.
     *
     * @param entity
     *         The entity that owns this ai.
     *
     * @return A new {@link AIEatGrass} Instance.
     */
    AIEatGrass newAIEatGrass(EntityLiving entity);

    /**
     * Returns A new {@link AIEntityNearest} Instance.
     *
     * @param entityLiving
     *         THe Entity that owns this ai.
     * @param entityClass
     *         The class type this entity should target.
     *
     * @return A new {@link AIEntityNearest} Instance.
     */
    AIFindEntityNearest newAIFindEntityNearest(EntityLiving entityLiving, Class<? extends Entity> entityClass);

    /**
     * Returns A new {@link AIEntityNearestPlayer} Instance.
     *
     * @param entityLiving
     *         THe Entity that owns this ai.
     *
     * @return A new {@link AIEntityNearestPlayer} Instance.
     */
    AIFindEntityNearestPlayer newAIFindEntityNearestPlayer(EntityLiving entityLiving);

    /**
     * Returns A new {@link AIFleeSun} Instance.
     *
     * @param mob
     *         the entity that owns this AI.
     * @param speed
     *         the speed at which the mob will move.
     *
     * @return A new {@link AIFleeSun} Instance.
     */
    AIFleeSun newAIFleeSun(EntityMob mob, double speed);

    /**
     * Returns A new {@link AIFollowGolem} Instance.
     *
     * @param villager
     *         The {@link Villager} that owns this AI.
     *
     * @return A new {@link AIFollowGolem} Instance.
     */
    AIFollowGolem newAIFollowGolem(Villager villager);

    /**
     * Returns A new {@link AIFollowOwner} Instance.
     *
     * @param entity
     *         the {@link Tameable} entity this AI belongs to.
     * @param speed
     *         Speed at which the entity will move
     * @param minDistance
     *         how close the entity will try to get to its owner.
     * @param maxDistance
     *         distance from owner the entity will try to stay in.
     *
     * @return A new {@link AIFollowOwner} Instance.
     */
    AIFollowOwner newAIFollowOwner(Tameable entity, double speed, float minDistance, float maxDistance);

    /**
     * Returns A new {@link AIFollowParent} Instance.
     *
     * @param animal
     *         the {@link EntityAnimal} this AI belongs to.
     * @param speed
     *         the speed the animal will move at.
     *
     * @return A new {@link AIFollowParent} Instance.
     */
    AIFollowParent newAIFollowParent(EntityAnimal animal, double speed);

    /**
     * Returns A new {@link AIHarvestFarmland} Instance.
     *
     * @param villager
     *         The {@link VIllager} this AI belongs to
     * @param speed
     *         speed the villager will walk at.
     *
     * @return A new {@link AIHarvestFarmland} Instance.
     */
    AIHarvestFarmland newAIHarvestFarmland(Villager villager, double speed);

    /**
     * Returns A new {@link AIHurtByTarget} Instance.
     *
     * @param entity
     *         The {@link EntityMob} this AI belongs to.
     * @param callForHelp
     *         whether or not this mob should rally allies.
     * @param targets
     *         entity classy types to target wiht this logic.
     *
     * @return A new {@link AIHurtByTarget} Instance.
     */
    AIHurtByTarget newAIHurtByTarget(EntityMob entity, boolean callForHelp, Class<? extends Entity>... targets);

    /**
     * Returns A new {@link AILeapAtTarget} Instance.
     *
     * @param entity
     *         The entity this AI belongs to.
     * @param leapMotionY
     *         Y motion the leap will be.
     *
     * @return A new {@link AILeapAtTarget} Instance.
     */
    AILeapAtTarget newAILeapAtTarget(EntityLiving entity, float leapMotionY);

    /**
     * Returns A new {@link AILookAtTradePlayer} Instance.
     *
     * @param villager
     *         The {@link Villager} This AI belongs to.
     *
     * @return A new {@link AILookAtTradePlayer} Instance.
     */
    AILookAtTradePlayer newAILookAtTradePlayer(Villager villager);

    /**
     * Returns A new {@link AILookAtVillager} Instance.
     *
     * @param golem
     *         the {@link IronGolem} that owns this AI.
     *
     * @return A new {@link AILookAtVillager} Instance.
     */
    AILookAtVillager newAILookAtVillager(IronGolem golem);

    /**
     * Returns A new {@link AILookIdle} Instance.
     *
     * @param entity
     *         The entity this AI belongs to.
     *
     * @return A new {@link AILookIdle} Instance.
     */
    AILookIdle newAILookIdle(EntityLiving entity);

    /**
     * Returns A new {@link AIMate} Instance.
     *
     * @param animal
     *         the {@link EntityAnimal} this AI belongs to.
     * @param speed
     *         the speed the animal will move at.
     *
     * @return A new {@link AIMate} Instance.
     */
    AIMate newAIMate(EntityAnimal animal, double speed);

    /**
     * Returns A new {@link AIMoveIndoors} Instance.
     *
     * @param entity
     *         The {@link EntityMob} that owns this AI.
     *
     * @return A new {@link AIMoveIndoors} Instance.
     */
    AIMoveIndoors newAIMoveIndoors(EntityMob entity);

    /**
     * Returns A new {@link AIMoveThroughVillage} Instance.
     *
     * @param entity
     *         The {@link EntityMob} that owns this AI.
     * @param speed
     *         the speed the animal will move at.
     * @param isNoctournal
     *         whether or not this creature is active at night time.
     *
     * @return A new {@link AIMoveThroughVillage} Instance.
     */
    AIMoveThroughVillage newAIMoveThroughVillage(EntityMob entity, double speed, boolean isNoctournal);

    /**
     * Returns A new {@link AIMoveTowardsRestriction} Instance.
     *
     * @param entity
     *         The {@link EntityMob} that owns this AI.
     * @param speed
     *         the speed the animal will move at.
     *
     * @return A new {@link AIMoveTowardsRestriction} Instance.
     */
    AIMoveTowardsRestriction newAIMoveTowardsRestriction(EntityMob entity, double speed);

    /**
     * Returns A new {@link AIMoveTowardsRestriction} Instance.
     *
     * @param entity
     *         The {@link EntityMob} that owns this AI.
     * @param speed
     *         the speed the animal will move at.
     * @param maxDistance
     *         the max distance away targets can be
     *
     * @return A new {@link AIMoveTowardsRestriction} Instance.
     */
    AIMoveTowardsTarget newAIMoveTowardsTarget(EntityMob entity, double speed, float maxDistance);

    /**
     * Returns A new {@link AINearestAttackableTarget} Instance.
     *
     * @param entity
     *         The {@link EntityMob}
     * @param target
     *         the class type of entities this mob should target.
     * @param targetChanve
     *         Change to target.
     *         Must be a positive number.  Chanve that AI is targeted will be random
     *         integer from this number. If the random Integer is equal to 0 then the
     *         target will fail, there for 1 will provide a 50% change of target, 10
     *         will have a 90% chance of target, and 100 will have a 99% chance of target.
     * @param shouldCheckSight
     *         whether or not the entity must be visible
     * @param nearbyOnly
     *         if the entity should only target nearby entities.
     *
     * @return A new {@link AINearestAttackableTarget} Instance.
     */
    AINearestAttackableTarget newAINearestAttackableTarget(EntityMob entity, Class<? extends Entity> target, int targetChanve, boolean shouldCheckSight, boolean nearbyOnly);

    /*public AIOcelotAttack newAIOcelotAttack();

   AIOcelotSit newAIOcelotSit();

   AIOpenDoor newAIOpenDoor();

   AIOwnerHurtByTarget newAIOwnerHurtByTarget();

   AIOwnerHurtTarget newAIOwnerHurtTarget();

   AIPanic newAIPanic();

   AIPlay newAIPlay();

   AIRestrictOpenDoor newAIRestrictOpenDoor();

   AIRestrictSun newAIRestrictSun();

   AIRunAroundLikeCrazy newAIRunAroundLikeCrazy();

   AISit newAISit();

   AISwimming newAISwimming();

   AITarget newAITarget();

   AITargetNonTamed newAITargetNonTamed();

   AITempt newAITempt();

   AITradePlayer newAITradePlayer();

   AIVillagerInteract newAIVillagerInteract();

   AIVillagerMate newAIVillagerMate();

   AIWander newAIWander();

   AIWatchClosest newAIWatchClosest();

   AIWatchClosest2 newAIWatchClosest2();
    /**/
}