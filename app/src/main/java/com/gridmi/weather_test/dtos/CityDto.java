package com.gridmi.weather_test.dtos;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CityDto{

	@SerializedName("visibility")
	private int visibility;

	@SerializedName("timezone")
	private int timezone;

	@SerializedName("main")
	private Main main;

	@SerializedName("clouds")
	private Clouds clouds;

	@SerializedName("sys")
	private Sys sys;

	@SerializedName("dt")
	private int dt;

	@SerializedName("coord")
	private Coord coord;

	@SerializedName("weather")
	private List<WeatherItem> weather;

	@SerializedName("name")
	private String name;

	@SerializedName("cod")
	private int cod;

	@SerializedName("id")
	private int id;

	@SerializedName("base")
	private String base;

	@SerializedName("wind")
	private Wind wind;

	public void setVisibility(int visibility){
		this.visibility = visibility;
	}

	public int getVisibility(){
		return visibility;
	}

	public void setTimezone(int timezone){
		this.timezone = timezone;
	}

	public int getTimezone(){
		return timezone;
	}

	public void setMain(Main main){
		this.main = main;
	}

	public Main getMain(){
		return main;
	}

	public void setClouds(Clouds clouds){
		this.clouds = clouds;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public void setSys(Sys sys){
		this.sys = sys;
	}

	public Sys getSys(){
		return sys;
	}

	public void setDt(int dt){
		this.dt = dt;
	}

	public int getDt(){
		return dt;
	}

	public void setCoord(Coord coord){
		this.coord = coord;
	}

	public Coord getCoord(){
		return coord;
	}

	public void setWeather(List<WeatherItem> weather){
		this.weather = weather;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public int getCod(){
		return cod;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBase(String base){
		this.base = base;
	}

	public String getBase(){
		return base;
	}

	public void setWind(Wind wind){
		this.wind = wind;
	}

	public Wind getWind(){
		return wind;
	}

	@Override
 	public String toString(){
		return 
			"CityDto{" + 
			"visibility = '" + visibility + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",main = '" + main + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",sys = '" + sys + '\'' + 
			",dt = '" + dt + '\'' + 
			",coord = '" + coord + '\'' + 
			",weather = '" + weather + '\'' + 
			",name = '" + name + '\'' + 
			",cod = '" + cod + '\'' + 
			",id = '" + id + '\'' + 
			",base = '" + base + '\'' + 
			",wind = '" + wind + '\'' + 
			"}";
		}

    public static class Clouds{

        @SerializedName("all")
        private int all;

        public void setAll(int all){
            this.all = all;
        }

        public int getAll(){
            return all;
        }

        @Override
         public String toString(){
            return
                "Clouds{" +
                "all = '" + all + '\'' +
                "}";
            }
    }

	public static class Coord{

		@SerializedName("lon")
		private double lon;

		@SerializedName("lat")
		private double lat;

		public void setLon(double lon){
			this.lon = lon;
		}

		public double getLon(){
			return lon;
		}

		public void setLat(double lat){
			this.lat = lat;
		}

		public double getLat(){
			return lat;
		}

		@Override
		 public String toString(){
			return
				"Coord{" +
				"lon = '" + lon + '\'' +
				",lat = '" + lat + '\'' +
				"}";
			}
	}

	public static class Main{

		@SerializedName("temp")
		private double temp;

		@SerializedName("temp_min")
		private double tempMin;

		@SerializedName("grnd_level")
		private int grndLevel;

		@SerializedName("humidity")
		private int humidity;

		@SerializedName("pressure")
		private int pressure;

		@SerializedName("sea_level")
		private int seaLevel;

		@SerializedName("feels_like")
		private double feelsLike;

		@SerializedName("temp_max")
		private double tempMax;

		public void setTemp(double temp){
			this.temp = temp;
		}

		public double getTemp(){
			return temp;
		}

		public void setTempMin(double tempMin){
			this.tempMin = tempMin;
		}

		public double getTempMin(){
			return tempMin;
		}

		public void setGrndLevel(int grndLevel){
			this.grndLevel = grndLevel;
		}

		public int getGrndLevel(){
			return grndLevel;
		}

		public void setHumidity(int humidity){
			this.humidity = humidity;
		}

		public int getHumidity(){
			return humidity;
		}

		public void setPressure(int pressure){
			this.pressure = pressure;
		}

		public int getPressure(){
			return pressure;
		}

		public void setSeaLevel(int seaLevel){
			this.seaLevel = seaLevel;
		}

		public int getSeaLevel(){
			return seaLevel;
		}

		public void setFeelsLike(double feelsLike){
			this.feelsLike = feelsLike;
		}

		public double getFeelsLike(){
			return feelsLike;
		}

		public void setTempMax(double tempMax){
			this.tempMax = tempMax;
		}

		public double getTempMax(){
			return tempMax;
		}

		@Override
		 public String toString(){
			return
				"Main{" +
				"temp = '" + temp + '\'' +
				",temp_min = '" + tempMin + '\'' +
				",grnd_level = '" + grndLevel + '\'' +
				",humidity = '" + humidity + '\'' +
				",pressure = '" + pressure + '\'' +
				",sea_level = '" + seaLevel + '\'' +
				",feels_like = '" + feelsLike + '\'' +
				",temp_max = '" + tempMax + '\'' +
				"}";
			}
	}

	public static class Sys{

		@SerializedName("country")
		private String country;

		@SerializedName("sunrise")
		private int sunrise;

		@SerializedName("sunset")
		private int sunset;

		public void setCountry(String country){
			this.country = country;
		}

		public String getCountry(){
			return country;
		}

		public void setSunrise(int sunrise){
			this.sunrise = sunrise;
		}

		public int getSunrise(){
			return sunrise;
		}

		public void setSunset(int sunset){
			this.sunset = sunset;
		}

		public int getSunset(){
			return sunset;
		}

		@Override
		 public String toString(){
			return
				"Sys{" +
				"country = '" + country + '\'' +
				",sunrise = '" + sunrise + '\'' +
				",sunset = '" + sunset + '\'' +
				"}";
			}
	}

	public static class WeatherItem{

		@SerializedName("icon")
		private String icon;

		@SerializedName("description")
		private String description;

		@SerializedName("main")
		private String main;

		@SerializedName("id")
		private int id;

		public void setIcon(String icon){
			this.icon = icon;
		}

		public String getIcon(){
			return icon;
		}

		public void setDescription(String description){
			this.description = description;
		}

		public String getDescription(){
			return description;
		}

		public void setMain(String main){
			this.main = main;
		}

		public String getMain(){
			return main;
		}

		public void setId(int id){
			this.id = id;
		}

		public int getId(){
			return id;
		}

		@Override
		 public String toString(){
			return
				"WeatherItem{" +
				"icon = '" + icon + '\'' +
				",description = '" + description + '\'' +
				",main = '" + main + '\'' +
				",id = '" + id + '\'' +
				"}";
			}
	}

	public static class Wind{

		@SerializedName("deg")
		private int deg;

		@SerializedName("speed")
		private double speed;

		public void setDeg(int deg){
			this.deg = deg;
		}

		public int getDeg(){
			return deg;
		}

		public void setSpeed(double speed){
			this.speed = speed;
		}

		public double getSpeed(){
			return speed;
		}

		@Override
		 public String toString(){
			return
				"Wind{" +
				"deg = '" + deg + '\'' +
				",speed = '" + speed + '\'' +
				"}";
			}
	}
}