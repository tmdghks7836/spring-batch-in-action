package com.jojoldu.batch.example.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@StepScope //이 SimpleJobTasklet Bean을 일반 singleton Bean으로 생성할 경우 아래와 같이 'jobParameters' cannot be found 에러가 발생합니다. StepScope 꼭 선언해야함

public class SimpleJobTasklet implements Tasklet {

    @Value("#{jobParameters[requestDate]}") String requestDate;

    public SimpleJobTasklet() {
        log.info(">>>>>>>>>>>>>>> 개인 tasklet 생성 ");
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        log.info(":>>>>> this is Step1");
        log.info(">>>>> requestDateggg = {}", requestDate);
        return RepeatStatus.FINISHED;
    }
}
