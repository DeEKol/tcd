<template>
	<div>
		<trips-list :trips="trips" />
	</div>
</template>

<script>
import TripsList from 'components/trips/TripList.vue'
import { getIndex } from 'util/collections'

export default {
	components: {
		TripsList
	},
	data() {
		return {
			trips: frontendData
		}
	},
	created() {
		addHandler(data => {
			let index = getIndex(this.trips, data.id)
			if (index > -1) {
				this.trips.splice(index, 1, data)
			} else {
				this.trips.push(data)
			}
		})
	}
}
</script>

<style scoped>

</style>