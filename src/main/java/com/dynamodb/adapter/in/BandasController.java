package com.dynamodb.adapter.in;

import com.dynamodb.adapter.in.dto.BandaDTO;
import com.dynamodb.adapter.in.dto.mapper.BandaInMapper;
import com.dynamodb.adapter.out.dto.DataResposta;
import com.dynamodb.core.domain.Banda;
import com.dynamodb.core.ports.in.ConsultarBandaUseCase;
import com.dynamodb.core.ports.in.ExcluirBandaUseCase;
import com.dynamodb.core.ports.in.IncluirBandaUseCase;
import com.dynamodb.core.ports.in.ListarBandasUseCase;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/banda")
@RequiredArgsConstructor
public class BandasController {
	
	private final ListarBandasUseCase listarBandasUseCase;
	
	private final ConsultarBandaUseCase consultarBandaUseCase;

	private final IncluirBandaUseCase incluirBandaUseCase;

	private final ExcluirBandaUseCase excluirBandaUseCase;

	private final BandaInMapper mapper;

	@ResponseBody
	@GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> listar () {

		final List<Banda> bandas = listarBandasUseCase.listar();
		
		final List<BandaDTO> bandasDTO = mapper.domainListToDTOList(bandas);
		
		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(bandasDTO);
		
		return ResponseEntity.ok(payloadSaida);
	}

	@ResponseBody
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> incluir(@RequestBody @Valid BandaDTO bandaDTO) {

		incluirBandaUseCase.incluir(mapper.requestToDomain(bandaDTO));

		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(new ArrayList<>());
		payloadSaida.getData().add(bandaDTO);

		return ResponseEntity.ok(payloadSaida);
	}

	@ResponseBody
	@PatchMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> alterar(@RequestBody @Valid BandaDTO bandaDTO) {

		incluirBandaUseCase.alterar(mapper.requestToDomain(bandaDTO));

		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(new ArrayList<>());
		payloadSaida.getData().add(bandaDTO);

		return ResponseEntity.ok(payloadSaida);
	}

	@ResponseBody
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> excluir(@RequestBody @Valid BandaDTO bandaDTO) {

		excluirBandaUseCase.excluir(mapper.requestToDomain(bandaDTO));

		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(new ArrayList<>());
		return ResponseEntity.ok(payloadSaida);
	}

	@ResponseBody
	@GetMapping(value="/nome/{nome_banda}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> consultarPorNome(
			@Valid @PathVariable(name = "nome_banda") String nome) {
		
		List<Banda> bandas = consultarBandaUseCase.consultarPorNome(nome);

		List<BandaDTO> bandaDTOResponse = mapper.domainListToDTOList(bandas);

		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(new ArrayList<>());
		payloadSaida.getData().addAll(bandaDTOResponse);

		return ResponseEntity.ok(payloadSaida);
	}

	@ResponseBody
	@GetMapping(value="/partiQL/nome/{nome_banda}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> consultarPorNomePartiQL(
			@Valid @PathVariable(name = "nome_banda") String nome) {

		List<Banda> bandas = consultarBandaUseCase.consultarPorNomePartiQL(nome);

		List<BandaDTO> bandaDTOResponse = mapper.domainListToDTOList(bandas);

		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(new ArrayList<>());
		payloadSaida.getData().addAll(bandaDTOResponse);

		return ResponseEntity.ok(payloadSaida);
	}

	@ResponseBody
	@GetMapping(value="/nome/{nome_banda}/genero/{genero_musical}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> consultarPorNomeEGeneroMusical(
			@PathVariable(name = "nome_banda") String nome,
			@PathVariable(name = "genero_musical") String generoMusical) {

		Banda banda = consultarBandaUseCase.consultarPorNomeEGeneroMusical(nome, generoMusical);

		BandaDTO bandaDTO = mapper.domainToDTO(banda);

		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(new ArrayList<>());
		payloadSaida.getData().add(bandaDTO);

		return ResponseEntity.ok(payloadSaida);
	}

	@ResponseBody
	@GetMapping(value="/ano_lancamento/{ano_lancamento}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> consultarPorAnoLancamento(
			@Valid @PathVariable(name = "ano_lancamento") Long anoLancamento) {

		List<Banda> bandas = consultarBandaUseCase.consultarPorAnoLancamento(anoLancamento);

		List<BandaDTO> bandaDTOResponse = mapper.domainListToDTOList(bandas);

		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(new ArrayList<>());
		payloadSaida.getData().addAll(bandaDTOResponse);

		return ResponseEntity.ok(payloadSaida);
	}

	@ResponseBody
	@GetMapping(value = "/ano_lancamento/inicial/{ano_lancamento_inicial}/final/{ano_lancamento_final}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DataResposta<BandaDTO>> consultarPorRangeAnoLancamento(
			@PathVariable(name = "ano_lancamento_inicial") Long anoLancamentoInicial,
			@PathVariable(name = "ano_lancamento_final") Long anoLancamentoFinal) {

		List<Banda> bandas = consultarBandaUseCase
				.consultarPorRangeAnoLancamento(anoLancamentoInicial, anoLancamentoFinal);

		List<BandaDTO> bandaDTOResponse = mapper.domainListToDTOList(bandas);

		DataResposta<BandaDTO> payloadSaida = new DataResposta<>(new ArrayList<>());
		payloadSaida.getData().addAll(bandaDTOResponse);

		return ResponseEntity.ok(payloadSaida);
	}
}