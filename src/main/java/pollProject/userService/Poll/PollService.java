package pollProject.userService.Poll;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient (
        name = "pollService",
        url = "${pollService.url}"
)

public interface PollService {
    @DeleteMapping(value = "/answers/delete/{id}")
    Void deleteAnswersByUserId(@PathVariable(value = "id") Long id, @RequestHeader(value = "delToken") String delToken);
}
