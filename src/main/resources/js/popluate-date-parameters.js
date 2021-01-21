AJS.MacroBrowser.setMacroJsOverride("countdown-days-until", {
    fields: {
        enum: {
            "Day": function(param, options) {
                var days = [];
                for (var i = 1; i <= 31; i++) {
                    days.push(i.toString());
                }

                param.enumValues = days;

                days.forEach(function(day) {
                    param.enumToI18nKeyMapping[day] = day;
                })

                return AJS.MacroBrowser.ParameterFields["enum"](param, options);
            },
            "Month": function(param, options) {
                var months = [];
                for (var i = 1; i <= 12; i++) {
                    months.push(i.toString());
                }

                param.enumValues = months;

                months.forEach(function(month) {
                    param.enumToI18nKeyMapping[month] = month;
                })

                return AJS.MacroBrowser.ParameterFields["enum"](param, options);
            },
            "Year": function(param, options) {
                var curYear = (new Date()).getFullYear();
                var years = [];
                for (var i = curYear; i < (curYear + 10); i++) {
                    years.push(i.toString());
                }

                param.enumValues = years;

                years.forEach(function(year) {
                    param.enumToI18nKeyMapping[year] = year;
                })

                return AJS.MacroBrowser.ParameterFields["enum"](param, options);
            }
        }
    }
})