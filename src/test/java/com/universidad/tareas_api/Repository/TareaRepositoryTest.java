package com.universidad.tareas_api.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.universidad.tareas_api.entity.Tarea;
import com.universidad.tareas_api.repository.TareaRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TareaRepositoryTest {

    @Autowired
    TareaRepository repo;

    @Autowired
    TestEntityManager em;

    @BeforeEach
    void setUp() {
        Tarea t = new Tarea();
        t.setTitulo("Pendiente");
        t.setCompletada(false);

        em.persistAndFlush(t);
    }

    @Test
    void findByCompletada_false_retornaUnaTarea() {
        assertThat(repo.findByCompletada(false))
                .hasSize(1);
    }
}