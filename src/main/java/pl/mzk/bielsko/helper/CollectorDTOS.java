package pl.mzk.bielsko.helper;

import pl.mzk.bielsko.dto.LineDTO;
import pl.mzk.bielsko.dto.StopDTO;

public class CollectorDTOS {

    private LineDTO lineDTO;
    private StopDTO stopDTO;

    public LineDTO getLineDTO() {
        return lineDTO;
    }

    public void setLineDTO(LineDTO lineDTO) {
        this.lineDTO = lineDTO;
    }

    public StopDTO getStopDTO() {
        return stopDTO;
    }

    public void setStopDTO(StopDTO stopDTO) {
        this.stopDTO = stopDTO;
    }
}
