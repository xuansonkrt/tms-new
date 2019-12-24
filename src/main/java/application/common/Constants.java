package application.common;

public class Constants {

    public static class SCHEMA {

        public static final String SYSTEM = "vhcm_system";
    }

    public static class RESPONSE_TYPE {

        public static final String SUCCESS = "SUCCESS";
        public static final String ERROR = "ERROR";
        public static final String WARNING = "WARNING";
        public static final String invalidPermission = "invalidPermission";
    }

    public static class RESPONSE_PAGE {

        public static final String UPDATE_AND_CLOSE = "updateAndClose";
    }
    
    public static class RESPONSE_CODE {

        public static final String SUCCESS = "success";
        public static final String DELETE_SUCCESS = "deleteSuccess";
        public static final String ERROR = "error";
        public static final String WARNING = "warning";
        public static final String RECORD_DELETED = "record.deleted";
        public static final String EMAIL_ADDRESS_DELETED = "emailAddress.deleted";
        public static final String RECORD_INUSED = "record.inUsed";
        public static final String RECORD_NOT_EXISTED = "recordNotExits";
        public static final String SYS_CAT_TYPE_USED = "sysCatTypeUsed";
    }

    public static class WARNING_TYPE {

        public static final Long EMAIL = 0l;
        public static final Long SMS = 1l;
        public static final Long EMAIL_SMS = 2l;
    }

    public interface API_METHOD {

        public static final String POST = "POST";
        public static final String GET = "GET";
        public static final String DELETE = "DELETE";
        public static final String PUT = "PUT";
    }

    public interface CORS_FILTER {

        public static final String ALLOW_METHODS = "POST, PUT, GET, OPTIONS, DELETE";
        public static final String ALLOW_HEADERS = "X-CACHEABLE, Authorization, Content-Type";
    }
    
    public interface SYS_CAT_TYPE {

        String WORK_PLACE = "WORK_PLACE";
        String MANAGE_ORG = "DSCQT";
        String CALCULATE_TYPE = "CTT";
    }
    
    public interface SYS_CAT {
        String SYS_CAT = "SYS_CAT";
        String SYS_CAT_CHILD = "SYS_CAT_CHILD";
    }
    
    public interface CATEGORY_TYPE {
        String CDNG = "CDNG";
        String EDU_LEVEL = "EDU_LEVEL";
        String PAPER_LEVEL = "PAPER_LEVEL";
        String HOC_HAM="HOC_HAM";
        String HOC_VI="HOC_VI";
        String CAP_BAC ="CAP_BAC";
    }
}
