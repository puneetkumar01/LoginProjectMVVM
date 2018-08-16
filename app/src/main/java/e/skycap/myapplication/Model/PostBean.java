 package e.skycap.myapplication.Model;

    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;




    public class PostBean
    {
        private String id;

        private String body;

        private String title;

        private String userId;

        public PostBean(String id, String body, String title, String userId) {
            this.id = id;
            this.body = body;
            this.title = title;
            this.userId = userId;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getBody ()
        {
            return body;
        }

        public void setBody (String body)
        {
            this.body = body;
        }

        public String getTitle ()
        {
            return title;
        }

        public void setTitle (String title)
        {
            this.title = title;
        }

        public String getUserId ()
        {
            return userId;
        }

        public void setUserId (String userId)
        {
            this.userId = userId;
        }

}