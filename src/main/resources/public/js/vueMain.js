new Vue({
    el: '#app',
    data: {
        sites: []
    },
    methods: {
        getSites: function() {
            axios.get("/api/stackOverflow").then(function(response) {
                this.sites = response.data;
            }.bind(this));
        }
    },
    mounted: function() {
        this.getSites();
    }
});