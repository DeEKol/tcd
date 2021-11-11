<template>
	<div style="position: relative; width: 300px;">
		<trip-form :trips="trips" :tripAttr="trip" />
	 	<trip-row v-for="trip in trips" 
		 	:key="trip.id"
			:trip="trip" 
			:editTrip="editTrip"
			:deleteTrip="deleteTrip" 
			:trips="trips" />
	</div>
</template>

<script>
import TripRow from 'components/trips/TripRow.vue'
import TripForm from 'components/trips/TripForm.vue'
export default {
	props: ['trips'],
	components: {
		TripRow,
		TripForm
	},
	data() {
		return {
			trip: null
		}
	},
	methods: {
		editTrip(trip) {
			this.trip = trip
		},
		deleteTrip(trip) {
			axios.delete('/trip/'  + trip.id).then(response => {
				if(response.status === 200) {
					this.trips.splice(this.trips.indexOf(trip), 1)
				}
			})
		}
	}
}
</script>

<style scoped>
</style>