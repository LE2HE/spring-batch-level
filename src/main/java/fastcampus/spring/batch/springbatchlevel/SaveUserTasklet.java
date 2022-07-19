package fastcampus.spring.batch.springbatchlevel;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SaveUserTasklet implements Tasklet {

    private final UserRepository userRepository;

    public SaveUserTasklet(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        // 유저 생성
        List<User> users = createUsers();
        // 유저 셔플
        Collections.shuffle(users);
        // 유저 저장
        userRepository.saveAll(users);
        // tasklet 종료
        return RepeatStatus.FINISHED;
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<>();
        // NORMAL
        for (int i=0;i<100;i++) {
            users.add(User.builder()
                    .totalAmount(1_000)
                    .username("test username" + i)
                    .build());
        }
        // SILVER
        for (int i=100;i<200;i++) {
            users.add(User.builder()
                    .totalAmount(200_000)
                    .username("test username" + i)
                    .build());
        }// GOLD
        for (int i=200;i<300;i++) {
            users.add(User.builder()
                    .totalAmount(300_000)
                    .username("test username" + i)
                    .build());
        }// VIP
        for (int i=300;i<400;i++) {
            users.add(User.builder()
                    .totalAmount(500_000)
                    .username("test username" + i)
                    .build());
        }
        return users;
    }
}
