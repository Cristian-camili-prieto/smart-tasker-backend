package smart.tasker.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smart.tasker.dto.TareaPendiente;
import smart.tasker.entity.Tarea;
import smart.tasker.repository.TareaRepository;
import smart.tasker.service.TareaService;

import java.util.List;

@Service
public class TareaServiceImp implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;


    @Override
    public List<Tarea>listarConCategoria() {
        return tareaRepository.findAllContainerJoin();
    }

    @Override
    public List<TareaPendiente> findAllPendiente() {
        return tareaRepository.findBtPendiente();
    }


}
