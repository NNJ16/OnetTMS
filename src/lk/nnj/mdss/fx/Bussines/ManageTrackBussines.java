package lk.nnj.mdss.fx.Bussines;

import lk.nnj.mdss.fx.Entity.Track;
import lk.nnj.mdss.fx.dao.Custom.TrackDAO;
import lk.nnj.mdss.fx.dao.DAOFactory;
import lk.nnj.mdss.fx.dto.TrackDTO;

public class ManageTrackBussines {
    static TrackDAO odao= (TrackDAO)
            DAOFactory.getInstance().getDAO
                    (DAOFactory.DAOTypes.TRC);

    public static boolean addTrack(TrackDTO dto) throws Exception {
        Track trc = new Track(dto.getTid(),dto.getDelDate(),dto.getStatus(),dto.getNote(),dto.getDelby(),dto.getOid());
        return odao.save(trc);
    }

    public static boolean deleteTrack(String oid) throws Exception {
        return odao.delete(oid);
    }

    public static boolean updateTrack(TrackDTO dto) throws Exception {
        Track trk= new Track(
                dto.getTid(),
                dto.getDelDate(),
                dto.getStatus(),
                dto.getNote(),
                dto.getDelby(),
                dto.getOid()
        );
        return odao.update(trk);
    }
    public static TrackDTO findTrack(String tid) throws Exception {
        Track tdk = odao.find(tid);
        if (tdk != null) {
            return new TrackDTO(
                    tdk.getTid(),
                    tdk.getDelDate(),
                    tdk.getStatus(),
                    tdk.getNote(),
                    tdk.getDelby(),
                    tdk.getOid()
            );
        }
        return null;
    }

}
