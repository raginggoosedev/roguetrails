package com.raginggoose.roguetrails.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.raginggoose.roguetrails.ecs.Mapper;
import com.raginggoose.roguetrails.ecs.components.EnemyComponent;
import com.raginggoose.roguetrails.ecs.components.TransformComponent;

public class EnemyMovementSystem extends IteratingSystem {
    public EnemyMovementSystem() {
        super(Family.all(EnemyComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent transformComponent = Mapper.transformMapper.get(entity);
        EnemyComponent enemyComponent = Mapper.enemyMapper.get(entity);

        Entity player = enemyComponent.player;
        TransformComponent playerTransformComponent = Mapper.transformMapper.get(player);

        Vector3 enemyPos = transformComponent.position;
        Vector3 playerPos = playerTransformComponent.position;

        float speed = enemyComponent.speed;

        float diffX = playerPos.x - enemyPos.x;
        float diffY = playerPos.y - enemyPos.y;

        float angle = MathUtils.atan2(diffY, diffX);

        if (diffX < -1 || diffX > 1)
            enemyPos.add(speed * MathUtils.cos(angle), 0, 0);
        if (diffY < -1 || diffY > 1)
            enemyPos.add(0, speed * MathUtils.sin(angle), 0);
    }
}